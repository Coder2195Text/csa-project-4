package mod.coder2195.america.entity.client;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.entity.custom.TankShellEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TankShellEntityRenderer extends ProjectileEntityRenderer<TankShellEntity> {
   public static final Identifier TEXTURE = new Identifier(AmericaMod.MOD_ID, "textures/entity/projectiles/tank_shell.png");

   public TankShellEntityRenderer(EntityRendererFactory.Context context) {
      super(context);
   }

   public Identifier getTexture(TankShellEntity arrowEntity) {
      return TEXTURE;
   }

   @Override
   public void render(TankShellEntity persistentProjectileEntity, float f, float g, MatrixStack matrixStack,
         VertexConsumerProvider vertexConsumerProvider, int i) {
      super.render(persistentProjectileEntity, f, g, matrixStack, vertexConsumerProvider, i);
   }
}
